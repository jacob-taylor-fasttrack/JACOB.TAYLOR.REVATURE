let externalElement=document.getElementById("external");
externalElement.onclick=()=>{
    externalElement.innerHTML="External change"
}

function externalFunc(element){
    element.innerHTML="external change with attribute"
}