function instructors(){

    var instructors=[{name:"Hasan",roomNumber:"111"},{name:"Furkan",roomNumber:"321"},
    {name:"Reyhan",roomNumber:"233"}

    ];
    var tableText="<table> <tr> <th>Name</th><th>Room</th></tr>";
    for (ins of instructors){
        console.log(ins.name+" "+ins.roomNumber);
        tableText+="<tr><td>"+ins.name+"</td><td>"+ins.roomNumber+"</td></tr>";
    }
    tableText+="</table>";
    console.log(tableText);
    document.getElementById("insList").innerHTML=tableText;

}





function sayHello() {
    console.log("Hello...");
    alert(".... Hello....");
}

function validateFormData() {
    var code = document.getElementById("code").value;
    var name = document.getElementById("name").value;
    var credit = document.getElementById("credit").value;
    console.log("Code:" + code);
   

    if(code==null||code==''){
        alert("Please enter a valid course code!");
        return false;
    }
    if(name==null||name==''){
        alert("Please enter a valid course name!");
        return false;
    }
    if(credit==null||credit==''){
        alert("Please enter a valid credit!");
        return false;
    }
    var course = {
        "code": code,
        "name": name,
        "credit":credit
    }
    console.log(course);
    return true;
}