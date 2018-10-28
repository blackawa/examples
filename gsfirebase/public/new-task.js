var init = function() {
    document.getElementById("form").addEventListener('submit', function(event) {
        event.preventDefault();
        var name = document.getElementById("name").value;
        // TODO: send it to firestore
        console.log(name);
    });
};

window.addEventListener('load', function() {
    init();
});
