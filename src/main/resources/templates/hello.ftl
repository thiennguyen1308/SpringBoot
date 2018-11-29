<html>

    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/resources/plugins/date/css/bootstrap.css" />
        <link rel="stylesheet" href="/resources/plugins/date/css/font-awesome.css" />
        <link rel="stylesheet" href="/resources/plugins/date/css/daterangeschau.css" />
        <script src="/resources/plugins/date/js/jquery.min.js"></script>
        </head>

    <body>
        <div class="container">
            <div class="pull-right marT15">
                <div id="daterangeschau"></div>
                <span id="myvalue"></span>
                </div>
            <div>

                </div>
            </div>
        <script type="text/javascript" src="/resources/plugins/date/js/moment.js"></script>
        <script type="text/javascript" src="/resources/plugins/date/js/datepicker.js"></script>
        <script type="text/javascript" src="/resources/plugins/date/js/dateformat.js"></script>
        <script type="text/javascript" src="/resources/plugins/date/js/daterangeschau.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                $('#daterangeschau').DateRangesChau({
                    aggregations: ['-'],
                    values: {
                        mode: 'tworanges',
                        calendars: 2,
                        dr1from: new Date('2018-03-15'),
                        dr1to: new Date('2018-04-15'),
                        dr2from: new Date('2018-03-01'),
                        dr2to: new Date('2018-03-30'),
                        daterangePreset: "custom",
                        comparisonEnabled: false,
                        removeComparison: true,
                        comparisonPreset: "previousperiod",
                        maxDate: 1,
                        minDate: 0,
                        dateFormat: "yyyy/MM/dd"
                    }
                });

                $("#daterangeschau").on("apply.event", function () {
                    var daterange = $.parseJSON($("#date_chau_value").val());
                    $("#myvalue").text(daterange.comparison + " - " + daterange.dr1from + " - " + daterange.dr1to + " - " + daterange.dr2from + " - " + daterange.dr2to);
                });

                $("#daterangeschau").on("cancel.event", function () {
                    alert('cancel');
                });
            });
            </script>
        </body>

    </html>