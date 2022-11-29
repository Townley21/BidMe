//
//  UserController.swift
//  BidMe
//
//  Created by Brandon Townley on 11/28/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import Foundation

class UserController {
    
    class func getUser(from email: String)->User {
        
        let url: String = "http://localhost:8080/api/users/get/" + email
        var id: Int = 0
        var email: String = ""
        var name: String = ""
        var password: String = ""
        var address: String = ""
        var contractor: Bool = false
        let task = URLSession.shared.dataTask(with: URL(string: url)!, completionHandler: {data, respone, error in
            guard let data = data, error == nil else {
                print("Something went wrong")
                return
            }
            
            print("--Data retrieved from DB---\n")
            print(data)
            //Have data
            var result: User?
            do {
                result = try JSONDecoder().decode(User.self, from: data)
            }
            catch {
                print("failed to convert: \(error)")
            }
            
            guard let json = result else {
                return
            }
            
            id = json.userID!
            email = json.email!
            name = json.name!
            password = json.password!
            address = json.address!
            contractor = json.contractor!
            print("id: %d", id)
            print("email: %s", email)
        })
        task.resume()
        
        var user: User = User()
        user.userID = id
        user.email = email
        user.name = name
        user.password = password
        user.address = address
        user.contractor = contractor
        print(user)
    
        return user
    }
}
