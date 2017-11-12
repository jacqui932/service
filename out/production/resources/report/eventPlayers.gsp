<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Event Players</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>

    <body>
        <h3 class="text-center">Entries for ${event.name}, ${event.dateTime.format('d MMMM yyyy')}</h3>
        <table class="table">
            <thead>
                <th width="20%">Players</th>
                <th width="80%">Comments</th>
            </thead>
            <tbody>
                <g:each in="${eventEntries}" var="eventEntry">
                    <tr style="page-break-inside:avoid;">
                        <td>
                            <ul class="list-unstyled">
                                <g:each in="${eventEntry.players}" var="player">
                                    <li><span class="text-uppercase">${player.lastName}</span>, ${player.firstName} <g:if test="${player.ebuNumber}">(${player.ebuNumber})</g:if></li>
                                </g:each>
                            </ul>
                        </td>
                        <td>${eventEntry.comments}</td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </body>
</html>
