#!/bin/bash

1. Packages

apt list | tee allpkg.txt

allpkg=()
while IFS= read -r line; do
     arrIN=(${line})
	 allpkg+=("'$arrIN'")
	 
done < allpkg.txt

apt list --installed| tee instpkg.txt
instpkg=()
while IFS= read -r ln; do
     arrIN2=(${line})	 
	 instpkg+=("'$arrIN2'")
	 
done < instpkg.txt

for val1 in ${instpkg[@]}; do
    declare -i flg=0
	
for val2 in ${allpkg[@]}; do 
    
if [ "$val1" == '$val2" ]; then
	flg=1
	fi
done

	zero=0;
	
if[[ $flg -eq $zero ]]; then
	echo "Unapproved Package Found $val1";
	exit;
	fi
	
done	

ele1=1oom
allpkg= ${allpkg[@]/$ele1}
(IFS=,; printf '[%s]' "${allpkg[*]}")


2. Services

systemctl --type=service | awk '{print $1}' | tee service.txt

allser=()

while IFS= read -r line; do
     allser+=("'$line'")
done < allservice.txt

newservicearray=()
for val1 in ${allser[@]}; do

    if [[ $val1 == *"service"* ]]; then
	newservicearray+=("'$val1'")
	fi
	
	done
	
systemctl --type=service --state=running | awk '{print $1}' | tee running.txt

runser=()
while IFS= read -r ln; do
    runser+=("'$ln'")
done < running.txt

newrunarray=()
for val1 in ${runser[@]}; do

if [[ $val1 == *"service"* ]]; then
   newrunarray+=("'$val1'")
   fi
done

(IFS=; printf '[%s]' "${newrunarray[*]}")

for val1 in ${newrunarray[@]}; do 
    declare -i flg=0
for val2 in ${newservicearray[@]}; do
if ["$val1" == "$val2"]; then
flg=1
fi
done
zero=0;
if [[ $flg -eq $zero ]]; then
   echo "Unapproved Service Found $val1";
   exit;
   fi
   
   done
   
   
3. Local Ports

  i=0
  end=1023
  ports=()
  while [ $i -le $end ]; do
        ports+=($i)
		i=$($i+1)
    done
	
	ele1=1023
	ports=( "${ports[@]/$ele1}" )
	
 ss -lntu | awk '{print $5}' |tee prt.txt

portsavail=()

while IFS= read -r line; do

    arrIN=(${line :})
    numval=${arrIN[1]}
  if [[ $numval =~ ^[0-9]+$ ]]
  then
   	portsavail+=($numval)
	else 
	   echo ""
	   fi
	  
done < prt.txt
(IFS=,; printf '[%s]' "{portsavail[*]}")
	  for val1 in ${portsavail[@]}; do
    
    declare -i flg=0
    
    for val2 in ${ports[@]}; do
        
        if [ "$val1" == "$val2" ]; then
            flg=1
        fi
    done
    
    zero=0;

    if [[ $flg -eq $zero ]]; then
    	echo "Unapproved port $val1";
  
    fi
   
   
done

	
	
4. Bing Map

wget 'http://dev.virtualearth.net/REST/v1/Locations?countryRegion=Australia&adminDistrict=QLD&locality=Sunnybank&postalCode=4109&addressLine=Firelight&key=Au4uT7KSxHflacW6DlcOaWPu6hKT51J0OVkbYHWGDj2ubfGP4VBKIhKT7BnLe-wX' -0 mfile.json

lat=$(jp .resourceSets[0].resources[0].point.coordinates[0] mfile.json)
long=$(jp.resourceSets[0].resources[0].point.coordinates[1] mfile.json)

mapst= 'http://dev.virtualearth.net/REST/v1/Imagery/Map/Road/-27.60467405,153.06140524/15?mapSize=500,500&key=Au4uT7KSxHflacW6DlcOaWPu6hKT51J0OVkbYHWGDj2ubfGP4VBKIhKT7BnLe-wX'

wget -0 map.jpg $mapst

5.Mac Addresses
 sudo arp-scan --interface=eth0 --localnet | awk '{print $2}'
 sudo arp-scan --interface=eth0 172.16.1.1
