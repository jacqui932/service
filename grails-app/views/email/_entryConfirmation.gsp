<!DOCTYPE html>
<html lang="en">
<body>
<div>
    <div style="border: 5px solid green; background-color: white; padding: 10px 5px">
        <table width="100%">
            <tr width="100%">
                <td width="25%"><img height="75" width="75" class="img-responsive text-center"
                                     src="http://assets.bridgeentry.com/herts.png"></td>
                <td width="50%"><h1><center><strong>Hertfordshire Bridge Association</strong></center></h1></td>
                <td width="25%" style="text-align: right"><img height="75" width="75" class="img-responsive text-center"
                                                               src="http://assets.bridgeentry.com/ebu.png"></td>
            </tr>
        </table>
    </div>

    <div class="col-md-12" style="padding-top: 10px">
        <p>
            Dear ${eventEntry.name},
        </p>

        <p>
            Thank you for entering the '${eventEntry.event.name}' on ${eventEntry.event.dateTime.format('d MMMM yyyy')} at ${eventEntry.event.dateTime.format('h:mm a')}.
        </p>

        <p>
            Details of the entry are:
        </p>
        <table style="padding: 20px">
            <tr>
                <td style="padding-right: 50px">Name</td>
                <td>${eventEntry.name}
            </tr>
            <tr>
                <td style="padding-right: 50px">Email</td>
                <td>${eventEntry.email}</td>
            </tr>
            <tr>
                <td style="padding-right: 50px">Players</td>
                <td>
                    <ul>
                        <g:each in="${eventEntry.players}">
                            <li>${it.firstName} ${it.lastName}<g:if test="${it.ebuNumber}">&nbsp;(${it.ebuNumber})</g:if></li>
                        </g:each>
                    </ul>
                </td>
            </tr>
            %{--<tr>--}%
                %{--<td style="padding-right: 50px">Payment Method</td>--}%
                %{--<td>${eventEntry.paymentMethod}</td>--}%
            %{--</tr>--}%
            <tr>
                <td style="padding-right: 50px">Date/Time Entered</td>
                <td><g:formatDate format="d MMMM yyyy" date="${eventEntry.dateEntered}" timeZone="Europe/London"/> at <g:formatDate format="h:mm a" date="${eventEntry.dateEntered}" timeZone="Europe/London"/></td>
            </tr>
            <g:if test="${eventEntry.heat}">
                <tr><td style="padding-right: 50px">Heat</td><td>${eventEntry.heat.club.name} on ${eventEntry.heat.dateTime.format('d MMMM yyyy')}</td></tr>
            </g:if>
            <tr>
                <td style="padding-right: 50px">Comments</td>
                <td>${eventEntry.comments}</td>
            </tr>
        </table>
        <p>
            If you need to make any changes to your entry, please contact us at <a href="mailto:hbatournamentsec@gmail.com">hbatournamentsec@gmail.com</a>
        </p>
        %{--<p>--}%
            %{--If you have paid online, you should shortly receive a confirmation of payment from our payment provider 'Stripe'.--}%
        %{--</p>--}%

        <g:if test="${eventEntry.paymentMethod in ['Cheque or Bank Transfer', 'Cheque', 'Bank Transfer']}">
            <p>
                %{--Otherwise, please either:--}%
                Please either:
            </p>
            <ul>
                <li>Send a cheque for <g:formatNumber number="${eventEntry.event.cost/100}" type="currency" currencyCode="GBP" /> made out to ${eventEntry.event.bankAccount.chequePayee} to ${eventEntry.event.bankAccount.chequeAddress} with a short note so we know which entry the payment is for</li>
                <li>Make a bank transfer of <g:formatNumber number="${eventEntry.event.cost/100}" type="currency" currencyCode="GBP" /> to Acc No: ${eventEntry.event.bankAccount.bankAccountNumber}, Sort Code: ${eventEntry.event.bankAccount.sortCode} as soon as possible using your name as a reference</li>
            </ul>
        </g:if>

        <p>
            We look forward to seeing you at the event,
        </p>

        <p>
            ${raw(eventEntry.event.season.instance.entryConfirmationSignature)}
        </p>
    </div>
</div>
</body>
</html>
