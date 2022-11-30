//
//  ListingController.swift
//  BidMe
//
//  Created by Brandon Townley on 11/29/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import Foundation

class ListingController {
    
    class func getAllListingsByUserID(from userID: String)->[Listing] {
        
        var listings: [Listing]? = [Listing()]
        let url: String = "http://localhost:8080/api/activeListings/getAllByUserID/" + userID
        let task = URLSession.shared.dataTask(with: URL(string: url)!, completionHandler: {data, respone, error in
            guard let data = data, error == nil else {
                print("Something went wrong")
                return
            }
            
            print("GET ALL LISTINGS CALLED\n")
            print("--Data retrieved from DB---\n")
            print(data)
            //Have data
            
            do {
                //loop and populate
                listings = try JSONDecoder().decode([Listing].self, from: data)
            }
            catch {
                print("failed to convert: \(error)")
            }
            
            guard let json = listings else {
                return
            }
            
            print(json)
            
        })
        task.resume()
        return listings!
    }
    
    class func getAllListingsByNULLID() -> [Listing] {
        
        var listings: [Listing]? = [Listing()]
        
        let url: String = "http://localhost:8080/api/activeListing/"
        let task = URLSession.shared.dataTask(with: URL(string: url)!, completionHandler: {data, respone, error in
            guard let data = data, error == nil else {
                print("Something went wrong")
                return
            }
            
            print("GET ALL LISTINGS CALLED\n")
            print("--Data retrieved from DB---\n")
            print(data)
            //Have data
            
            do {
                //loop and populate
                listings = try JSONDecoder().decode([Listing].self, from: data)
            }
            catch {
                print("failed to convert: \(error)")
            }
            
            guard let json = listings else {
                return
            }
            
            print(json)
            
        })
        task.resume()
        return listings!
        
    }
}
