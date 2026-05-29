#  Koko Frontend

A location-based service delivery app for rural South Africa.

## Project Structure
- index.html       — Login & Register
- home.html        — Map + Business Listing
- catalogue.html   — Products per Business
- checkout.html    — Cart & Payment
- orders.html      — Order History & Tracking
- profile.html     — User Profile
- css/style.css    — Global Styles
- js/api.js        — All API calls to Spring Boot
- js/auth.js       — Auth logic
- js/cart.js       — Cart logic
- js/map.js        — Leaflet map
- spring-boot-config/CorsConfig.java — Add to your Spring Boot project

## Running in IntelliJ
1. Open this folder in IntelliJ IDEA
2. Open index.html
3. Click the browser icon (top right of editor)
4. Frontend runs at http://localhost:63342

## Backend
- Spring Boot must run on http://localhost:8080
- Add CorsConfig.java to your Spring Boot project
- Update BASE_URL in js/api.js if your port differs

## Payment (South Africa)
- PayFast: https://www.payfast.co.za
- Ozow: https://ozow.com
- Cash on Delivery supported
