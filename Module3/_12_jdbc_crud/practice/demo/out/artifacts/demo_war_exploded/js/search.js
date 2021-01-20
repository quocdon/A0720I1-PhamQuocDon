$(document).ready(function() {
    $('#search').click(function(event) {
        let searchName= $('#searchName').val();
        $.post('searchName', {
            name : searchName
        }, function(responseText) {
            $('#result').html(responseText);
        });
    });
});