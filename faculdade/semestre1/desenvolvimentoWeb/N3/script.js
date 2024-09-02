function toggleMenu() {
    var menu = document.getElementById("nav");
    var icon = document.querySelector(".menu-icone");

    if (menu.style.width === "250px") {
        menu.style.width = "0";
        icon.classList.remove("change");
    } else {
        menu.style.width = "250px";
        icon.classList.add("change");
    }
}
