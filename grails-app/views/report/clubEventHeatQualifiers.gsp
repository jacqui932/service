<!DOCTYPE html>
<html lang="en">
<head>
    <title>${event.name} Qualifiers from ${club.name}</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
<h2 class="text-center">${event.name} Qualifiers from ${club.name}</h2>
<ul>
    <g:each in="${heats}" var="heat">
        <li style="page-break-inside:avoid;">
            <h3>Heat held on ${heat.dateTime.format('d MMMM yyyy')}</h3>
            <table class="table">
                <thead>
                <tr>
                    <th>Players</th>
                    <th>Status</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${heat.heatQualifiers}" var="heatQualifier">
                    <tr>
                        <td>
                            <ul class="list-unstyled">
                                <g:each in="${heatQualifier.heatQualifierPlayers}" var="player">
                                    <li>${player.firstName} ${player.lastName} <g:if
                                            test="${player.ebuNumber}">(${player.ebuNumber})</g:if></li>
                                </g:each>
                            </ul>
                        </td>
                        <td>
                            <g:if test="${heatQualifier.eventEntry}">Entered</g:if>
                            <g:else>
                                <g:if test="${heatQualifier.withdrawn}">Declined</g:if>
                                <g:else>Not Responded</g:else>
                            </g:else>
                        </td>
                    </tr>
                </g:each>
                </tbody>
            </table>
        </li>
    </g:each>
</ul>
</body>
</html>
