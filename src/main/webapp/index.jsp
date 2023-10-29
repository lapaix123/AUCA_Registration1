<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>
  <meta charset="UTF-8" />
  <title>AUCA system</title>
  <link rel="stylesheet" href="css/style.css" />
  <!-- Boxicons CDN Link -->
  <link href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css" rel="stylesheet" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <style>
    body {
      position: relative;
      text-align: center; /* Center the content horizontally */
    }

    .watermark {
      position: fixed;
      opacity: 0.3; /* Adjust the opacity as needed */
      top: 50%; /* Center vertically */
      left: 50%; /* Center horizontally */
      transform: translate(-50%, -50%); /* Center the watermark itself */
      pointer-events: none; /* Allows clicking through the watermark */
    }
  </style>
</head>
<body>
<%@include file="pages/Navar.jsp"%>
<div class="watermark">
  <img src="image/logo.png" alt="Watermark Image">
</div>


<%--<section class="home-section">--%>
<%--  <h1> Wel come to AUCA Student Registration MS</h1>--%>

<%--</section>--%>

<script>
  let sidebar = document.querySelector(".sidebar");
  let sidebarBtn = document.querySelector(".sidebarBtn");
  sidebarBtn.onclick = function () {
    sidebar.classList.toggle("active");
    if (sidebar.classList.contains("active")) {
      sidebarBtn.classList.replace("bx-menu", "bx-menu-alt-right");
    } else sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
  };
</script>
</body>
</html>
