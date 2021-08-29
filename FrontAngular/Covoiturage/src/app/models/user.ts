import { Roles } from "./roles";
export interface User {
    idUser : number;
    
    fullName:string;
    
    username : string;

	email: string;

    telephone:number;
    
    password: string;

    Role :Roles ;
}
