   // $(document).ready(function(){
   //      alert('hello dom');
   //      $("#insert").click(function(e){
   //          var id=$(this).attr('id')
   //          var name = $('#name').val();
   //          var visibility=$('#visibility').val();
   //          alert(name+""+visibility)
   //          $.post("/topic",
   //              {
   //                  name: name,
   //                  visibility: visibility
   //              },
   //              function(data, status){
   //                  alert("Data: " + data + "\nStatus: " + status);
   //                  alert('added');
   //                  location.reload();
   //                });
   //           });
   //       });
   //

   $(document).ready(function(){

       $("#insert").click(function(e){

           var name=$('#name').val();
           var visibility=$('#visibility').val();
           $.ajax({
               type: "POST",
               url: "/topic",

               data: "name=" + name + "&visibility=" + visibility,
               success: function (response) {
                   // we have the response
                   alert("Topic Inserted Successfully");
                   $('#CreateTopic').modal('hide');
               },
               error: function (e) {
                 //  console.log( " xhr.responseText: " + xhr.responseText + " //status: " + status + " //Error: "+error );
                   alert("ERROR");
                   $('#CreateTopic').modal('hide');
               }
           });


   });

       $("#invite").click(function(e){
           alert('bbbb');
           var email=$('#email').val();
           var topic=$('#topic').val();
           $.ajax({
               type: "POST",
               url: "/sendInvite",

               data: "email=" + email+ "&topic=" + topic,
               success: function (response) {
                   // we have the response
                   alert("Invite Sent Successfully");
                   $('#SendInvite').modal('hide');
               },
               error: function (e) {
                   alert("Error");
                   $('#SendInvite').modal('hide');
               }
           });
       });

       $("#shareDocumentBtn").click(function(e){
               alert('documnt called');
           var formData = new FormData();
           formData.append("file",$("#document")[0].files[0])
           formData.append("description",$("#description").val());
           formData.append("topicDocument",$("#topicDocument").val());

           $.ajax({
                   type: "POST",
                   url: "/document",
                   data: formData,
                   contentType: false,
                   processData: false,

                   success: function (response) {
                       // we have the response
                       alert('Document Shared Successfully');
                       $('#shareDocument').modal('hide');
                   },
                   error: function (e) {
                       alert("Error");
                       $('#shareDocument').modal('hide');
                   }
               });

       });

       $("#shareLinkBtn").click(function(e){
           alert('documnt called');
           var formData = new FormData();

           formData.append("link",$("#link").val());
           formData.append("descriptionLink",$("#descriptionLink").val());
           formData.append("topicLink",$("#topicLink").val());
           $.ajax({
               type: "POST",
               url: "/linkShare",
               data: formData,
               contentType: false,
               processData: false,
                cache:false,
               success: function (response) {
                   // we have the response
                   alert("Link Shared Successfully");
                   $('#shareLink').modal('hide');
               },
               error: function (e) {
                   alert("Error");
                   $('#shareLink').modal('hide');
               }
           });

       });
       });