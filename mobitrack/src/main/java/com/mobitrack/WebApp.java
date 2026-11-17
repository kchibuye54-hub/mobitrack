package com.mobitrack;

import io.javalin.Javalin;

public class WebApp {

    public static void main(String[] args) {

        Javalin app =
                Javalin.create(config -> {

                    config.staticFiles.add("/public");

                }).start(7000);

        app.get("/", ctx -> {

            ctx.html("""
<!DOCTYPE html>
<html>

<head>

<title>MobiTrack Dashboard</title>

<link rel="stylesheet"
href="/css/style.css">

</head>

<body>

<div class="navbar">

<div class="logo">
📱 MobiTrack
</div>

</div>

<div class="container">

<h1 style="margin-top:30px;">
Dashboard
</h1>

<div class="cards">

<div class="card">
<h2>K1099</h2>
<p>Total Income</p>
</div>

<div class="card">
<h2>K50</h2>
<p>Total Expenses</p>
</div>

<div class="card">
<h2>K1049</h2>
<p>Balance</p>
</div>

</div>

<div class="cards">

<div class="card">

<h2>Transactions</h2>

<p>View all transactions</p>

<a class="btn"
href="/transactions">

Open

</a>

</div>

<div class="card">

<h2>Add Transaction</h2>

<p>Add Income or Expenses</p>

<a class="btn"
href="/add">

Open

</a>

</div>

<div class="card">

<h2>Reports</h2>

<p>View Monthly Report</p>

<a class="btn"
href="/report">

Open

</a>

</div>

</div>

</div>

</body>

</html>
""");

        });

        app.get("/transactions", ctx -> {

            ctx.html("""
<!DOCTYPE html>

<html>

<head>

<title>Transactions</title>

<link rel="stylesheet"
href="/css/style.css">

</head>

<body>

<div class="navbar">

<div class="logo">
📱 MobiTrack
</div>

</div>

<div class="container">

<h1>Transactions</h1>

<table>

<tr>
<th>ID</th>
<th>Description</th>
<th>Amount</th>
<th>Type</th>
</tr>

<tr>
<td>1</td>
<td>Allowance</td>
<td>500</td>
<td>INCOME</td>
</tr>

<tr>
<td>2</td>
<td>Airtime</td>
<td>50</td>
<td>EXPENSE</td>
</tr>

</table>

<br>

<a class="btn"
href="/">

Back

</a>

</div>

</body>

</html>
""");

        });

        app.get("/report", ctx -> {

            ctx.html("""
<!DOCTYPE html>

<html>

<head>

<title>Monthly Report</title>

<link rel="stylesheet"
href="/css/style.css">

</head>

<body>

<div class="navbar">

<div class="logo">
📱 MobiTrack
</div>

</div>

<div class="container">

<h1>Monthly Report</h1>

<div class="cards">

<div class="card">
<h2>K1099</h2>
<p>Total Income</p>
</div>

<div class="card">
<h2>K50</h2>
<p>Total Expense</p>
</div>

<div class="card">
<h2>K1049</h2>
<p>Balance</p>
</div>

</div>

<br>

<a class="btn"
href="/">

Back

</a>

</div>

</body>

</html>
""");

        });

        app.get("/add", ctx -> {

            ctx.html("""
<!DOCTYPE html>

<html>

<head>

<title>Add Transaction</title>

<link rel="stylesheet"
href="/css/style.css">

</head>

<body>

<div class="navbar">

<div class="logo">
📱 MobiTrack
</div>

</div>

<div class="container">

<h1>Add Transaction</h1>

<form>

<p>Amount</p>

<input type="number">

<br><br>

<p>Description</p>

<input type="text">

<br><br>

<p>Type</p>

<select>

<option>INCOME</option>

<option>EXPENSE</option>

</select>

<br><br>

<button>

Save Transaction

</button>

</form>

<br>

<a class="btn"
href="/">

Back

</a>

</div>

</body>

</html>
""");

        });

        System.out.println(
                "===================================");

        System.out.println(
                "MOBITRACK RUNNING");

        System.out.println(
                "http://localhost:7000");

        System.out.println(
                "===================================");
    }
}

