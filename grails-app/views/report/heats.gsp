<!DOCTYPE html>
<html lang="en">
<head>
    <title>Heats</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
<h2 class="text-center">Heats</h2>
<ul>
    <g:each in="${heats}" var="heat">
        <li style="page-break-inside:avoid;">
            <h3>${heat.key.name}</h3>
            <table class="table">
                <thead>
                <tr>
                    <th>Date</th>
                    <th>Club</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${heat.value}" var="heat_val">
                    <tr>
                        <td>${heat_val.dateTime.format('d MMMM yyyy')}</td>
                        <td>${heat_val.club.name}</td>
                    </tr>
                </g:each>
                </tbody>
            </table>
        </li>
    </g:each>
</ul>
</body>
</html>
