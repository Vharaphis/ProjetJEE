function closePopupDetail() {
    var popup = document.getElementById("popupDetail");
    popup.style.display = "none";
}

function openPopupDetail() {
    var popup = document.getElementById("popupDetail");
    popup.style.display = "flex";
}

function closePopupEdit() {
    var popup = document.getElementById("popupEdit");
    popup.style.display = "none";
}

function openPopupEdit() {
    var popup = document.getElementById("popupEdit");
    popup.style.display = "flex";
}

function closePopupCreateUser() {
    var popup = document.getElementById("popupCreateUser");
    popup.style.display = "none";
}

function openPopupCreateUser() {
    var popup = document.getElementById("popupCreateUser");
    popup.style.display = "flex";
}

function closePopupCreateCompany() {
    var popup = document.getElementById("popupCreateCompany");
    popup.style.display = "none";
}

function openPopupCreateCompany() {
    var popup = document.getElementById("popupCreateCompany");
    popup.style.display = "flex";
}

function filterTabWithSearchInput()  {
    var filterInput = document.getElementById('filterInput');
    var userTable = document.getElementById('userTable').getElementsByTagName('tbody')[0];

    filterInput.addEventListener('input', function () {
        var searchText = filterInput.value.toLowerCase();

        Array.from(userTable.getElementsByTagName('tr')).forEach(function (row) {
            var text = row.innerText.toLowerCase();
            var isVisible = text.includes(searchText);
            row.style.display = isVisible ? '' : 'none';
        });
    });
}