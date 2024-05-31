import { Injectable, inject } from '@angular/core';
import { User } from '../models/user';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private http = inject(HttpClient);


  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>('api/user/getAllUsers');
  }

  addUser(user: User) {
    return this.http.post<User[]>('api/user/createUser', user);
  }

  updateUser(user: User) {
    return this.http.post<User[]>('api/user/updateUser', user);
  }

  deleteUser(id: string) {
    return this.http.delete<User[]>(`api/user/deleteUser/${id}`);
  }
}
