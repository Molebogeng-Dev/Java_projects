// === KOKO CART ===

function getCart() {
  return JSON.parse(localStorage.getItem("koko_cart") || "[]");
}

function saveCart(cart) {
  localStorage.setItem("koko_cart", JSON.stringify(cart));
  updateCartBadge();
}

function addToCart(product) {
  const cart = getCart();
  const existing = cart.find(i => i.id === product.id);
  if (existing) {
    existing.qty += 1;
  } else {
    cart.push({ ...product, qty: 1 });
  }
  saveCart(cart);
  showToast(`${product.name} added to cart!`);
}

function removeFromCart(productId) {
  const cart = getCart().filter(i => i.id !== productId);
  saveCart(cart);
}

function updateCartBadge() {
  const cart = getCart();
  const total = cart.reduce((sum, i) => sum + i.qty, 0);
  const badge = document.getElementById("cart-badge");
  if (badge) badge.textContent = total;
}

function getCartTotal() {
  return getCart().reduce((sum, i) => sum + (i.price * i.qty), 0).toFixed(2);
}

function showToast(message) {
  const toast = document.createElement("div");
  toast.textContent = message;
  toast.style.cssText = `
    position: fixed; bottom: 2rem; right: 2rem;
    background: #2d6a4f; color: white;
    padding: 1rem 1.5rem; border-radius: 8px;
    font-weight: 600; z-index: 9999;
  `;
  document.body.appendChild(toast);
  setTimeout(() => toast.remove(), 2500);
}
