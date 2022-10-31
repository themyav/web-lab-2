function sendAreaCheckRequest(clicked) {
    if (clicked || (validate() && checkValue($('#R').val(), 1, 5, 1))) {

        $.ajax({
            type: 'get',
            url:'http://localhost:8600/web-lab-2/ControllerServlet',
            data: {'X' : $("input:checkbox[name='X']:checked").val(), 'Y' : $('#Y').val(), 'R' : $('#R').val()},
            success:function(response){
                $(response).insertAfter($("#respTable > tbody > tr:first"));
                document.getElementById('errorMessage').innerText = '';

            }
        });
    } else {
        document.getElementById('errorMessage').innerText = 'Проверьте корректность введенных значений!';
    }
}

function sendCleanRequest() {
    $.ajax({
        type: 'get',
        url:'http://localhost:8600/web-lab-2/ControllerServlet',
        data: {'action' : 'clean'},
        success:function(){
            cleanTable();
        }
    });
}

function sendFillRequest() {
    $.ajax({
        type: 'get',
        url:'http://localhost:8600/web-lab-2/ControllerServlet',
        data: {'action' : 'fill'},
        success:function(response){
            fillTable(response);
        }
    });
}


$(document).ready(function () {

    $('#submit').click(function () {
        sendAreaCheckRequest(false);
    });

    $('#cleanButton').click(function () {
        sendCleanRequest();
    });

    $('#Y').on('input', function () {
        this.value = this.value.replace(/[^0-9.,\-]/g, '');
    });

    $("input:checkbox").on('click', function () {
        let $box = $(this);
        if ($box.is(":checked")) {
            let group = "input:checkbox[name='" + $box.attr("name") + "']";
            console.log(group);
            $(group).prop("checked", false);
            $box.prop("checked", true);
        } else {
            $box.prop("checked", false);
        }
    });

    $('#graph').on('click', function (e) {
        let x_pos = e.pageX - document.getElementById('graph').offsetLeft;
        let y_pos = e.pageY - document.getElementById('graph').offsetTop;
        let zero_x = document.getElementById('graph').offsetWidth / 2;
        let zero_y = document.getElementById('graph').offsetHeight / 2;

        let y_cord = -1 * (y_pos - zero_y), x_cord = (x_pos - zero_x), R = $('#R').val();
        if (checkValue(R, 1, 5, 1)) {
            let w = R / 0.8;
            let k = w / zero_x;
            x_cord *= k;
            y_cord *= k;
            document.getElementById('errorMessage').innerText = '';

            let x_val = Math.min(Math.max(Math.round(x_cord.toFixed(4)).toString(), -3), 3);
            let new_element = "input:checkbox[value=" + x_val.toString() + "]"
            let old_element = "input:checkbox[name='X']:checked";

            $(old_element).prop("checked", false);
            $(new_element).prop("checked", true);

            document.getElementById('Y').value = y_cord.toFixed(4).toString();

            let X = $("input:checkbox[name='X']:checked").val();
            let Y = $("#Y").val();
            if (X == null || Y == null || !checkValue(X, -5, 3, 0) || !checkValue(Y, -3, 5, 0)) {
                document.getElementById('errorMessage').innerText = 'Значение X или Y в данной точке не корректно!';
            } else {
                sendAreaCheckRequest(true);
                restoreCanvas();
                drawPoint(x_pos, y_pos, '', ctx);
                document.getElementById('errorMessage').innerText = '';
            }
        } else {
            document.getElementById('errorMessage').innerText = 'Введите корректный R!';
        }
    });
});