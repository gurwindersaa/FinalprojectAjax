var itemApp = itemApp || {}

itemApp.selctedItem = 0
    console.log("tem")

itemApp.getAll = async() =>{
//    const response = await fetch('http://localhost:8084/Inventory?action=getAll')
    const items = await response.json()
    console.log(items)
    
    for(let item of items){
    let table = document.createElement('table');
    table.innerHTML ="<tr><td>"+item.id+"</td><td>"+item.catagory+"</td><td>working fine"+item.name+"</td><td>"+item.price+"</td></tr>"
        document.querySelector("#items").appendChild(table)
    }
}

document.addEventListener("DOMContentLoaded", itemApp.getAll)
