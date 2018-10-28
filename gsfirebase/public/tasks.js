var init = function() {
    firebase.auth().onAuthStateChanged(function(user) {
        if (user) {
            var db = firebase.firestore();
            db.collection("tasks").where("authorId", "==", user.uid).get().then((querySnapshot) => {
                var tasks = document.getElementById("tasks");
                querySnapshot.forEach(doc => {
                    console.log(`${doc.id} => ${doc.data()}`);
                    var listItem = document.createElement("li");
                    listItem.textContent = doc.data().name;
                    tasks.appendChild(listItem);
                });
            });
        } else {
            // redirect to sign in page
            window.location.href = "/sign.html";
        }
    });
};

window.addEventListener('load', function() {
    init();
});
