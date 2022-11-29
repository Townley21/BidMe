//
//  User.swift
//  BidMe
//
//  Created by Brandon Townley on 11/28/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import Foundation

struct User: Codable {
    var userID: Int?
    var name: String?
    var email: String?
    var password: String?
    var address: String?
    var contractor: Bool?
}
