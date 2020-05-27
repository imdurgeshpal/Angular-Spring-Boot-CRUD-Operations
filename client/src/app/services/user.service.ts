import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private upersons: User[] = [
    {
      id: 1,
      firstName: 'Durgesh',
      lastName: 'Pal'
    },
    {
      id: 2,
      firstName: 'Ankur',
      lastName: 'Pal'
    }
  ];

  constructor(private httpClient: HttpClient) { }

  getAllUsers(): Observable<User[]> {
    return this.httpClient.get<User[]>('/user/getAllUsers');
  }

  createUser(user: User): Observable<User> {
    return this.httpClient.post<User>('/user/createUser', user);
  }

  updateUser(user: User) {
    const index = this.upersons.findIndex(u => user.id === u.id);
    this.upersons[index] = user;
  }
  deleteUser(user: User) {
    this.upersons.splice(this.upersons.indexOf(user), 1);
  }
  findUserById(id: number): Observable<User> {
    return this.httpClient.get<User>(`/user/findUserById/${id}`);
  }

}
