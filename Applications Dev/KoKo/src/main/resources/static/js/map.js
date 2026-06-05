// === KOKO MAP ===

let map;
let userMarker;

function initMap() {
  // Default location
  map = L.map('map').setView([-26.1550, 28.3840], 12);

  L.tileLayer('https://{s}.basemaps.cartocdn.com/light_all/{z}/{x}/{y}{r}.png', {
    attribution: '© OpenStreetMap © CARTO',
    subdomains: 'abcd',
    maxZoom: 20}).addTo(map);

  map.on('click', function(e) {
    const { lat, lng } = e.latlng;

    if (userMarker) {
      map.removeLayer(userMarker);
    }

    userMarker = L.marker([lat, lng]).addTo(map)
      .bindPopup('Your location').openPopup();

    loadBusinesses(lat, lng);
  });

  // Try get user's real location
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(function(pos) {
      const lat = pos.coords.latitude;
      const lng = pos.coords.longitude;
      map.setView([lat, lng], 12);
      userMarker = L.marker([lat, lng]).addTo(map)
        .bindPopup('You are here').openPopup();
      loadBusinesses(lat, lng);
    });
  }
}

window.onload = initMap;
