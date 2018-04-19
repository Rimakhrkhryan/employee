/**
 * draw table of old employees and table of new employees
 * @param employees is all employees
 */
function drawTables(employees) {
    var oldEmployeeTable = "<tr> <th>Id</th><th>Name</th><th>Last Name</th> <th>Address</th><th>Job Title</th></tr>";
    var newEmployeeTable = "<tr> <th>Id</th><th>Name</th><th>Last Name</th> <th>Address</th><th>Job Title</th></tr>";
    var content;
    for (var i = 0; i < employees.length; i++) {
        content = "<tr><td>" + employees[i]["id"] + "</td><td>" + employees[i]["name"] + "</td><td>" +
            employees[i]["lastName"] + "</td><td>" + employees[i]["address"] + "</td><td>"
            + employees[i]["jobTitle"] + "</td></tr>";
        if (document.cookie.indexOf(employees[i]["id"]) < 0) {
            if (employees[i]["flag"] == "add") {
                newEmployeeTable += content;
            } else {
                oldEmployeeTable += content;
            }
        }

    }
    document.getElementById("newEmployees").innerHTML = newEmployeeTable;
    document.getElementById("oldEmployees").innerHTML = oldEmployeeTable;
}

/**
 * save changes
 * added employees have transferred into table of old employees
 * cleaning cookes except login
 */

function save() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var cookies = document.cookie.split(";");
            for (var i = 0; i < cookies.length; i++) {
                var cookie = cookies[i];
                var eqPos = cookie.indexOf("=");
                var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
                if (name != "login") {
                    document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
                }
            }
            drawPage();
        }
    };
    xhttp.open("POST", "save", true);
    xhttp.send();
}

/**
 * crate new cooke whit deleted user's id
 */

function deleteEmployee() {

    var id = document.getElementById("deletedEmployeesId").value;
    document.getElementById("deletedEmployeesId").value = ""
    for (var i = 0; i < employees.length; i++) {

        if (employees[i]["id"] == id) {

            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    var cooke = id + " =" + id
                    document.cookie = cooke;
                    drawPage();
                }
            };
            xhttp.open("POST", "/delete", true);
            var json = JSON.stringify(employees[i]);
            xhttp.send(json);

        }
    }

}

/**
 * whit ajax request get all employees list and draw page
 */

function drawPage() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            employees = JSON.parse(this.responseText);
            drawTables(employees);
        }
    };
    xhttp.open("GET", "/loadUsers", true);
    xhttp.send();

}

drawPage();