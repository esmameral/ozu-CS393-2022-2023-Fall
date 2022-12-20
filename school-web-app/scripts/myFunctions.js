function printInstructors(instructors){
    var tableText="<table> <tr> <th>Name</th><th>Room</th></tr>";
    for (ins of instructors){
        console.log(ins.name+" "+ins.officeNumber);
        tableText+="<tr><td>"+ins.name+"</td><td>"+ins.officeNumber+"</td></tr>";
    }
    tableText+="</table>";
    console.log(tableText);
    document.getElementById("insList").innerHTML=tableText;

}

function getAllInstructors() {

    axios.get("http://localhost:8080/instructors")
      .then(res => {
        const insList = res.data;
        console.log(insList);
        printInstructors(insList);
      })

    
}

function createCourse() {
    var code = document.getElementById("code").value;
    var name = document.getElementById("name").value;
    var credit = document.getElementById("credit").value;
    const course = {
        "code": code,
        "name": name,
        "credit":credit
    }
    axios.post("http://localhost:8080/courses",course)
      .then(res => {
        const course = res.data;
        console.log(course);
       
      }).catch(function (error) {
        console.log(error);
      });
    

    
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
    createCourse();
    return true;
}