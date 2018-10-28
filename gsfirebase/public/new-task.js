var init = function() {
    firebase.auth().onAuthStateChanged(function(user) {
        document.getElementById("form").addEventListener('submit', function(event) {
            event.preventDefault();
            var name = document.getElementById("name").value;
            var db = firebase.firestore();
            db.collection("tasks").add({
                name: name,
                authorId: user.uid
            }).then(function(docRef) {
                console.log("Document written with ID: ", docRef.id);
                window.location.href = "/tasks.html";
            }).catch(function(error) {
                console.error("Error adding document: ", error);
            });
        });
    });
};

window.addEventListener('load', function() {
    init();
});
