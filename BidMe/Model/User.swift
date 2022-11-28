//
//  User.swift
//  BidMe
//
//  Created by Brandon Townley on 11/28/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import Foundation

struct UserData: Decodable {
    let users: [User]
    
    private enum CodingKeys: String, CodingKey {
    case users = "results"
    }
}


struct User: Decodable {
    
    let userID: Int?
    let name: String?
    let email: String?
    let password: String?
    let address: String?
    let contractor: bool?
    
    private enum CodingKeys: String, CodingKey {
        
    }
}
