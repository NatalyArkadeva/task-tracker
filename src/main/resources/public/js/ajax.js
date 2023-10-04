function edit(id) {
    $.get("/ajax/getTask/"+id, function( data ) {
        $('#editId').text(data.id);
        $('#editEndDate').val(data.endDate);
//        $('#editTo').val(data.to);
//        $('#editMessage').val(data.message);
//        $('#editSubject').val(data.subject);
        $('#editModal').modal('show');
    });
}

function save() {
    postData = {
                id:$('#editId').text(),
                endDate:$('#editEndDate').val(),
//                to:$('#editTo').val(),
//                message:$('#editMessage').val(),
//                subject:$('#editSubject').val(),
                version:0
                };

    $.ajax({
        url: '/ajax/saveTask',
        cache: false,
        dataType: "json",
        data: JSON.stringify(postData),
        contentType: "application/json; charset=utf-8",
        processData: false,
        method: "POST",
        success: function (response) {
            $('#editModal').modal('hide');
            $("#records").html('');
            loadList();
        },
        error: function( error) {
            alert(error.responseText);
        }
    });
}

function loadList() {
        $.get("/ajax/all", function( data ) {
            $.each(data, function(key, value) {
                $("#records").append(
                    "<div class='col-md-2'>"+value.title+"</div>"+
                    "<div class='col-md-4'>"+value.description+"</div>"+
                    "<div class='col-md-4'>"+value.startDate+"</div>"+
                    "<div class='col-md-4'>"+value.endDate+"</div>"+
                    "<div class='col-md-2' onclick='edit("+value.id+")'><i class='fa-solid fa-pen-to-square'></i></div>"
                );
            });
        });
}

