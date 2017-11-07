<!DOCTYPE html>
<html lang="en">
<head>
    <title>Outstanding Payments</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
<h2 class="text-center">Outstanding Payments ${new Date().format('d MMMM yyyy')}</h2>

<g:each in="${data}" var="group">
    <div class="container">
        <h3>${group.key.name}</h3>

        <table class="table">
            <thead>
            <th width="25%">Players</th>
            <th width="25%">Date Entered</th>
            <th width="25%">Payment Method</th>
            <th width="25%"><span class="pull-right">Amount Owed</span></th>
            </thead>
            <tbody>
            <g:each in="${group.value}" var="eventEntry">
                <tr style="page-break-inside:avoid;">
                    <td>
                        <ul class="list-unstyled">
                            <g:each in="${eventEntry.players}" var="player">
                                <li><span class="text-uppercase">${player.lastName}</span>, ${player.firstName}</li>
                            </g:each>
                        </ul>
                    </td>
                    <td>${eventEntry.dateEntered.format('d MMMM yyyy')}</td>
                    <td>${eventEntry.paymentMethod}</td>
                    <td class="pull-right"><g:formatNumber number="${eventEntry.event.cost / 100}" type="currency" currencyCode="GBP" currencySymbol="&pound;"/></td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</g:each>
</body>
</html>
