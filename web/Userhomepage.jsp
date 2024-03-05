<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Home Page</title>
    <style>
        header {
            background-color: #f2f2f2;
            padding: 20px;
            text-align: center;
        }

        nav {
            background-color: orangered;
            color: white;
            padding: 10px;
            text-align: center;
        }

        nav a {
            color: white;
            text-decoration: none;
            padding: 10px;
        }

        main {
            padding: 20px;
        }

        form {
            margin: 0 auto;
            max-width: 400px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        select, input[type="date"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: orangered;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .time-slot-container {
            display: flex;
            flex-wrap: wrap;
            gap: 10px;
            width: 100%;
        }

        .time-slot {
            border: 1px solid #ccc;
            padding: 10px;
            cursor: pointer;
            border-radius: 5px;
            width: calc(25% - 10px); /* 25% width with gap of 10px */
            box-sizing: border-box; /* Ensure padding is included in width calculation */
        }

        .time-slot.selected {
            background-color: #007bff;
            color: #fff;
        }
    </style>
</head>
<body>
<header>
    <h1>Welcome, User!</h1>
    <p>Hello, ${name}!</p>
</header>

<nav>
    <a href="Userhomepage.jsp">Dashboard</a>
    <a href="Appointments.jsp">Appointments</a>
    <a href="ProfServ">Profile</a>
    <a href="#">Settings</a>
    <a href="login.html">Logout</a>
    <a href="ClinicDetails.html">Visits clinics</a>
</nav>

<main>
    <form id="appointmentForm" action="Appointments.jsp">

        <label for="clinicName">Clinic Name:</label>
        <select id="Clinics" name="clinic">
            <option>select</option>
            <% try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mrdoc", "root", "root");
                Statement tm = con.createStatement();
                String querry = "select* from clinic";
                ResultSet rs = tm.executeQuery(querry);
                while (rs.next()) {
            %>
            <option><%=rs.getString("clinic_name")%></option>
            <%
                }
            } catch (Exception e) {
                out.println(e);
            }

            %>
        </select><br><br>
        <label for="doctorName">Doctor Name:</label>
        <select id="Doctors" name="doctor">
            <option>select</option>
            <% try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mrdoc", "root", "root");
                Statement tm = con.createStatement();
                String querry = "select* from doctor_registration";
                ResultSet rs = tm.executeQuery(querry);
                while (rs.next()) {
            %>
            <option><%=rs.getString("Dname")%></option>
            <%
                }
            } catch (Exception e) {
                out.println(e);
            }

            %>
        </select><br><br>

        <label for="appointmentDate">Appointment Date:</label>
        <input type="date" id="appointmentDate" name="date" required>

        <label for="appointmentTime">Appointment Time:</label>
        <div class="time-slot-container" id="timeSlots">
            <!-- Time slots will be dynamically added here -->
        </div>

        <input type="submit" onclick="bookAppointment()">
    </form>
</main>

<script>
    // Define available time slots
    const timeSlots = [
        "10:00 AM", "10:30 AM",
        "11:00 AM", "11:30 AM",
        "12:00 PM", "12:30 PM",
        "01:00 PM", "01:30 PM",
        "02:00 PM", "02:30 PM",
        "03:00 PM", "03:30 PM"
    ];

    // Get the container element for time slots
    const timeSlotContainer = document.getElementById("timeSlots");

    // Dynamically generate time slots
    timeSlots.forEach(slot => {
        const timeSlotElement = document.createElement("div");
        timeSlotElement.textContent = slot;
        timeSlotElement.classList.add("time-slot");
        timeSlotElement.addEventListener("click", () => {
            // Remove 'selected' class from all time slots
            document.querySelectorAll(".time-slot").forEach(slot => {
                slot.classList.remove("selected");
            });
            // Add 'selected' class to the clicked time slot
            timeSlotElement.classList.add("selected");
        });
        timeSlotContainer.appendChild(timeSlotElement);
    });
</script>

</body>
</html>