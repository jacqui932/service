<!DOCTYPE html>
<html lang="en">
<head>
    <title>Victor Ludorum</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
    <h3 class="text-center">Victor Ludorum 2017/18</h3>
    <h4>Open</h4>
    <table class="table">
        <thead>
            <th>Name</th>
            <th>Points</th>
        </thead>
        <tbody>
            <g:each in="${all}" var="eventEntryPlayer">
                <tr>
                    <td>${eventEntryPlayer.lastName}, ${eventEntryPlayer.firstName}</td>
                    <td>${eventEntryPlayer.victorLudorumPoints}</td>
                </tr>
            </g:each>
        </tbody>
    </table>
    <h4>Intermediate</h4>
    <table class="table">
        <thead>
        <th>Name</th>
        <th>Points</th>
        </thead>
        <tbody>
        <g:each in="${intermediate}" var="eventEntryPlayer">
            <tr>
                <td>${eventEntryPlayer.lastName}, ${eventEntryPlayer.firstName}</td>
                <td>${eventEntryPlayer.victorLudorumPoints}</td>
            </tr>
        </g:each>
        </tbody>
    </table>
    <h4>Cadet</h4>
    <table class="table">
        <thead>
        <th>Name</th>
        <th>Points</th>
        </thead>
        <tbody>
        <g:each in="${cadet}" var="eventEntryPlayer">
            <tr>
                <td>${eventEntryPlayer.lastName}, ${eventEntryPlayer.firstName}</td>
                <td>${eventEntryPlayer.victorLudorumPoints}</td>
            </tr>
        </g:each>
        </tbody>
    </table>
</body>
</html>
