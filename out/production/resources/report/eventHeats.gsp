<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Event Heats</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>

    <body>
        <h3 class="text-center">Heats for ${event.name}, ${event.dateTime.format('d MMMM yyyy')}</h3>
        <table class="table">
            <thead>
                <th>Date</th>
                <th>Club</th>
                <th>Visitors Info</th>
            </thead>
            <tbody>
                <g:each in="${heats}" var="heat">
                    <tr class="">
                        <td>${heat.dateTime.format('d MMMM yyyy')}</td>
                        <td>${heat.club.name}</td>
                        <td>${heat.visitorsInfo}</td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </body>
</html>
