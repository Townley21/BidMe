//
//  ListingPhotoCollectionViewCell.swift
//  BidMe
//
//  Created by Axel Mora on 11/1/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import UIKit

class ListingPhotoCollectionViewCell: UICollectionViewCell {
    
    @IBOutlet var imageView: UIImageView!
    
    static let identifier = "ListingPhotoCollectionViewCell"
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
    }
    
    public func configure(with image: UIImage) {
        imageView.image = image
    }
    
    static func nib() -> UINib {
        return UINib(nibName: "ListingPhotoCollectionViewCell", bundle: nil)
    }
    
}
