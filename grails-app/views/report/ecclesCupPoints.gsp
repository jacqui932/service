<!DOCTYPE html>
<html lang="en">
<head>
    <title>Outstanding Payments</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
<h2 class="text-center">Eccles Cup Points</h2>

<g:each in="${data}" var="group">
    <div class="container">
        <h3>${group.key}</h3>

        <table class="table">
            <thead>
            <th width="33%">Player</th>
            <th width="33%">Masterpoint Rank</th>
            <th width="33%" class="pull-right">Eccles Points</th>
            </thead>
            <tbody>
            <g:each in="${group.value}" var="player">
                <tr style="page-break-inside:avoid;">
                    <td><span class="text-uppercase">${player.lastName}</span>, ${player.firstName} <g:if
                            test="${player.ebuNumber}">(${player.ebuNumber})</g:if></td>
                    <td>${player.rank}</td>
                    <td class="pull-right">${player.ecclesPoints}</td>
                </tr>
            </g:each>
            </tbody>
        </table>

        <div class="row text-right">
            <div class="col-xs-2 col-xs-offset-8">
                <hr/>

                <p><strong>Total Points:</strong></p>
            </div>

            <div class="col-xs-2">
                <hr/>
                <strong>${group.value.sum { it.ecclesPoints != null ? it.ecclesPoints : 0 }}</strong>
            </div>
        </div>
    </div>
</g:each>
</body>
</html>
