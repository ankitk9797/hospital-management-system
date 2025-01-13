import { Injectable } from '@angular/core';

const TOKEN = 's_token';
const USER = 's_user';

@Injectable({
  providedIn: 'root',
})
export class UserStorageService {
  constructor() {}

  // Save token to localStorage
  public saveToken(token: string): void {
    window.localStorage.removeItem(TOKEN);
    window.localStorage.setItem(TOKEN, token);
  }

  // Get token from localStorage (handles null case with fallback)
  static getToken(): string {
    return localStorage.getItem(TOKEN) || ''; // Fallback to empty string if null
  }

  // Save user to localStorage
  public saveUser(user: any): void {
    window.localStorage.removeItem(USER);
    window.localStorage.setItem(USER, JSON.stringify(user));
  }

  // Get user from localStorage (handles null case)
  static getUser(): any {
    const user = localStorage.getItem(USER);
    return user ? JSON.parse(user) : null; // Return null if not found
  }

  // Get user ID (handles null case gracefully)
  static getUserId(): string {
    const user = this.getUser();
    return user && user.userId ? user.userId : ''; // Return empty string if user or userId is null
  }

  // Get user role (handles null case gracefully)
  static getUserRole(): string {
    const user = this.getUser();
    return user && user.role ? user.role : ''; // Return empty string if user or role is null
  }

  // Check if the logged-in user is a CLIENT
  static isAdminLoggedIn(): boolean {
    if (!this.getToken()) {
      return false; // No token, not logged in
    }
    const role: string = this.getUserRole();
    return role === 'ADMIN';
  }

  // Check if the logged-in user is a COMPANY
  static isDoctorLoggedIn(): boolean {
    if (!this.getToken()) {
      return false; // No token, not logged in
    }
    const role: string = this.getUserRole();
    return role === 'DOCTOR';
  }

  // Sign out the user by clearing localStorage
  static signOut(): void {
    window.localStorage.removeItem(TOKEN);
    window.localStorage.removeItem(USER);
  }
}
