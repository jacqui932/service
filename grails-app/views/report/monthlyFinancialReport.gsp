<!DOCTYPE html>
<html lang="en">
<head>
    <title>Financial Report</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
<h2 class="text-center">Financial Report - ${month} ${year}</h2>

<g:each in="${data}" var="group">
    <div class="container">

        <h3>${group.key.name} (${group.value.size()} <g:if
                test="${group.value.size() > 1}">entries</g:if><g:else>entry</g:else>)</h3>
        <table class="table">
            <thead>
            <tr class="row">
                <th style="width: 20%">Players</th>
                <th style="width: 20%">Date Cleared</th>
                <th style="width: 20%">Paid By</th>
                <th style="width: 20%">Payment Ref</th>
                <th style="width: 20%"><span class="pull-right">Amount</span></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${group.value}" var="entry">
                <tr class="row" style="page-break-inside:avoid;">
                    <td>
                        <ul class="list-unstyled">
                            <g:each in="${entry.eventEntry.players}" var="player">
                                <li><span class="text-uppercase">${player.lastName}</span>, ${player.firstName}</li>
                            </g:each>
                        </ul>
                    </td>
                    <td>${entry.dateCleared.format('d MMMM yyyy')}</td>
                    <td>${entry.paymentMethod}</td>
                    <td>${entry.paymentRef}</td>
                    <td class="pull-right"><g:formatNumber number="${group.key.cost / 100}" type="currency" currencyCode="GBP" currencySymbol="&pound;"/></td>
                </tr>
            </g:each>
            </tbody>
        </table>

        <div class="row text-right">
            <div class="col-xs-2 col-xs-offset-8">
                <hr />
                <p><strong>Sub Total : </strong></p>
            </div>
            <div class="col-xs-2">
                <hr />
                <strong><g:formatNumber number="${ (group.key.cost / 100) * group.value.size() }" type="currency" currencyCode="GBP" currencySymbol="&pound;"/></strong>
            </div>
        </div>
    </div>
</g:each>

<div class="container">
    <div class="row text-right">
        <div class="col-xs-2 col-xs-offset-8">
            <hr />
            <p><strong>Total : </strong></p>
        </div>
        <div class="col-xs-2">
            <hr />
            <strong><g:formatNumber number="${data.entrySet().sum { it.key.cost * it.value.size() } / 100}" type="currency" currencyCode="GBP" currencySymbol="&pound;"/></strong>
        </div>
    </div>
</div>
</body>
</html>
