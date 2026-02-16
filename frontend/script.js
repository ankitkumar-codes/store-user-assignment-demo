let selectedLat = null;
let selectedLng = null;

let marker;
let tempMarker; 

// Initialize map
const map = L.map('map').setView([28.7041, 77.1025], 13);

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '© OpenStreetMap'
}).addTo(map);


// Auto move map when pincode entered
document.getElementById('pincode').addEventListener('input', function () {
  const pincode = this.value.trim();

  // Only trigger when full pincode entered
  if (pincode.length !== 6) return;

  fetch(`https://nominatim.openstreetmap.org/search?format=json&postalcode=${pincode}&country=india`)
    .then(res => res.json())
    .then(data => {
      if (data && data.length > 0) {
        const lat = parseFloat(data[0].lat);
        const lon = parseFloat(data[0].lon);

        map.setView([lat, lon], 14);

        if (tempMarker) {
          map.removeLayer(tempMarker);
        }

        tempMarker = L.marker([lat, lon]).addTo(map);
      }
    })
    .catch(err => console.log(err));
});



// On map click
map.on('click', function (e) {
    selectedLat = e.latlng.lat;
    selectedLng = e.latlng.lng;

    // 🔥 REMOVE TEMP MARKER WHEN USER CLICKS
    if (tempMarker) {
        map.removeLayer(tempMarker);
        tempMarker = null;
    }

    if (marker) {
        map.removeLayer(marker);
    }

    marker = L.marker([selectedLat, selectedLng]).addTo(map);
});

// Form submit
document.getElementById('userForm').addEventListener('submit', function (e) {
    e.preventDefault();

    if (selectedLat === null || selectedLng === null) {
        alert("Please select location on map");
        return;
    }

    const data = {
        name: document.getElementById('name').value,
        pincode: document.getElementById('pincode').value,
        latitude: selectedLat,
        longitude: selectedLng
    };

    fetch('http://localhost:8080/users/register', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    })
        .then(res => res.json())
        .then(response => {
            document.getElementById('result').innerText =
                response.store
                    ? `Assigned Store: ${response.store.name}`
                    : 'No store available for this pincode';
        })
        .catch(() => {
            document.getElementById('result').innerText = 'Error occurred';
        });
});
