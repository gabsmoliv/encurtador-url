export const TOKEN_KEY = "TOKEN_API";

export const isAuthenticated = () => localStorage.getItem('user') !== null;


export function authHeader() {
  // return authorization header with jwt token
  let user = JSON.parse(localStorage.getItem('user') || '');

  if (user && user.token) {
      return  user.token;
  } else {
      return '';
  }
}