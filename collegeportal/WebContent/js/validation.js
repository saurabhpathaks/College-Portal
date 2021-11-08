function checkData(data){
	
	if(data.length==0)
	return false
	
	else
	return true
	
	
	
}
function checkLength(data){
	
	if(data.length<=9)
	return false
	
	else
	return true
	
	
	
}
function checkCombo(data)
{
if(data=="default")
return false
else
return true

}
function checkBox_Radio(arr)
{
flag=0
for(i=0;i<arr.length;i++)
{
if(arr[i].checked)
{
flag=1;
break;

}
if(flag==0)

return false
else
return true
}
}