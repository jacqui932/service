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
            Dear <g:each in="${heatQualifier.heatQualifierPlayers}" var="heatQualifierPlayer">${heatQualifierPlayer.firstName}, </g:each>
        </p>
        <h3>
            Congratulations!
        </h3>
        <p>
            You have qualified for the '${heatQualifier.heat.event.name}' due to your great finishing position in the heat at ${heatQualifier.heat.club.name} on ${heatQualifier.heat.dateTime.format('d MMMM yyyy')}.
        </p>
        <p>
            This event will be happening at ${heatQualifier.heat.event.venue.addressLine_1}, ${heatQualifier.heat.event.venue.addressLine_2}, ${heatQualifier.heat.event.venue.postcode} on ${heatQualifier.heat.event.dateTime.format('d MMMM yyyy')}.
        </p>
        <p>
            More details about the event can be found on the <a href="http://www.hertsbridge.co.uk/">Hertforshire Bridge Association web page</a>
        </p>
        <p>
            The entry fee for the team is only <g:formatNumber number="${heatQualifier.heat.event.cost/100}" type="currency" currencyCode="GBP" /> and <a href="http://herts.bridgeentry.com/#/event/${heatQualifier.heat.event.id}">an entry form can be found here.</a>
        </p>
        <br/>
        <p>
            We hope to see you at the event,
        </p>
        <p>
            ${raw(heatQualifier.heat.event.season.instance.entryConfirmationSignature)}
        </p>
    </div>
</div>
</body>
</html>
