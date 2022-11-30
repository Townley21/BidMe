//
//  Listing.swift
//  BidMe
//
//  Created by Brandon Townley on 11/29/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import Foundation

struct Listing: Codable {
    var listingID: Int?
    var user: User?
    var contractor: User?
    var title: String?
    var address: String?
    var galleryID: Int?
    var price: Double?
    var desc: String?
}
