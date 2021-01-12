$(document).ready(function() {
    $('#search').click(function(event) {
        let productName= $('#productName').val();
        $.post('search', {
            name : productName
        }, function(responseText) {
            $('#result').html(responseText);
        });
    });
});