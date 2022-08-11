1. #CPU Hogging Process
function hogging {Get-Process | Where-Object CPU -gt 350} hogging

2. #Check Antimalware
if ( Get-MpComputerStatus | Select-Object AMServiceEnabled ) {echo "Window Defender Antimalware Toolkit is enable" }

3.
function Check_approved {
    
    $val=Get-CimInstance -Class Win32_Product 
    # $val
    try{
        Mkdir c:\Service_report
     }
     catch{
        Write-Host "folder already exist"
     }
    Get-CimInstance -Class Win32_Product | 
    select-object Name,Version,Caption,IdentifyingNumber,Vendor,description,installState | 
       Export-Csv -UseCulture -NoTypeInformation -LiteralPath c:\Program_report\report.csv

       Write-Host "Program report stored in c:\Service_report\report.csv "

    foreach ($items in $val)
    {   
            
    
    
            if($approved -contains $items.Vendor -or $aaprovedprogrm -contains $items.name ){
    
                # Write-Host "===================== Approved Program running ======================="
                # Write-Host "Program: $($items.name)"
                # Write-Host "Version: $($items.name)"
                # Write-Host "Vendor: $($items.Vendor)"
    
            }
            else {
                Write-Host "===================== Unapproved Program Detected ======================="
                Write-Host "Program: $($items.name)"
                Write-Host "Version: $($items.name)"
                Write-Host "Vendor: $($items.Vendor)"
            }
    
    
      
    
    }
    
}

Check_approved

function remove_program($item){
    $aaprovedprogrm.Remove($item) 
    Write-Host "List after removed: $($aaprovedprogrm)"
 }

4.#Running Services
Get-Service | Where-Object status -eq running
#Removing Services

	

5.#Checking NTP
function CheckNTP {

    $val=Get-ItemProperty -Path HKLM:\SYSTEM\STATE\DATETIME
    
    Write-Host "NTP Status: $($val.'NetworkTime Enabled')"
    
}
CheckNTP
