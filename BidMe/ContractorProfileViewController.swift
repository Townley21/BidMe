//
//  ContractorProfileViewController.swift
//  BidMe
//
//  Created by Axel Mora on 11/1/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import UIKit
import MapKit

class ContractorProfileViewController: UIViewController, UITableViewDelegate, UITableViewDataSource, MKMapViewDelegate{
    
    @IBOutlet var username: UILabel!
    @IBOutlet var fullName: UILabel!
    @IBOutlet var email: UILabel!
    @IBOutlet var image: UIImageView!
    //@IBOutlet var tableView: UITableView!
    @IBOutlet var mapView: MKMapView!
    
    let manager = CLLocationManager();
    
    var nameData = ["Tree Trimming", "Carpet Installation"]
    var addressData = ["One University Dr, Camarillo, CA 93012", "One University Dr, Camarillo, CA 93012"]
    var priceData = ["1400.00", "2300.00"]
    
    var invoiceNameData0 = ["Labor", "Materials"]
    var invoicePriceData0 = ["900.00", "400.00"]
    
    var invoiceNameData1 = ["Labor", "Materials"]
    var invoicePriceData1 = ["1500.00", "800.00"]
    
    let lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
    
    var index = 0

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        title = "Profile"
        username?.text = "@HGoat23"
        fullName?.text = "Henry Goat"
        email?.text = "Henry.goat@gmail.com"
        
        //circular image (crops edges off of square photo)
        image.layer.borderWidth = 1
        image.layer.masksToBounds = false
        image.layer.borderColor = UIColor.black.cgColor
        image.layer.cornerRadius = image.frame.height / 2
        image.clipsToBounds = true
        
        mapView.delegate = self
        createAnnotations(locations: annotationLocations)

        /*
        //History Table setup
        let nib = UINib(nibName: "ListingTableViewCell", bundle: nil)
        tableView.register(nib, forCellReuseIdentifier: "ListingTableViewCell")
        tableView.delegate = self
        tableView.dataSource = self
        */
         
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return addressData.count
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        self.index = indexPath.row
        performSegue(withIdentifier: "InvoiceSeg", sender: self)
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "ListingTableViewCell", for: indexPath) as! ListingTableViewCell
        
        cell.addressLabel?.text = addressData[indexPath.row]
        cell.bidCountLabel?.text = priceData[indexPath.row]
        cell.nameLabel?.text = nameData[indexPath.row]
        cell.bidStaticLabel?.text = ""
        cell.descriptionLabel?.text = lorem
        return cell
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        
        if segue.identifier == "InvoiceSeg" {
            let dest = segue.destination as! InvoiceViewController
            
            let invoiceNameData = [invoiceNameData0, invoiceNameData1]
            let invoicePriceData = [invoicePriceData0, invoicePriceData1]
            
            dest.nameData = invoiceNameData[index]
            dest.priceData = invoicePriceData[index]
            dest.titleOfJob = nameData[index]
            dest.totalprice = priceData[index]
        }
    }
    
    let annotationLocations = [
        ["title": "Cronies Sports Grill" , "latitude": 34.220220153566146, "longitude": -119.05331693066982],
        ["title": "Instituiton Ale Company" , "latitude": 34.217176763461964, "longitude": -119.01923559884497],
        ["title": "Wood Ranch BBQ & Grill" , "latitude": 34.21901201556222, "longitude": -119.05528295282262],
        ["title": "Cagami Ramen" , "latitude": 34.21875832451282, "longitude": -119.04530720680104],
        ["title": "Ric's Restaurant and Sports Lounge" , "latitude": 34.236435424231395, "longitude": -119.03776751726916]
    ]
    
    func createAnnotations(locations: [[String: Any]]) {
        for location in locations {
            let annotations = MKPointAnnotation()
            annotations.title = location["title"] as? String
            annotations.coordinate = CLLocationCoordinate2D(latitude: location["latitude"] as! CLLocationDegrees, longitude: location["longitude"] as! CLLocationDegrees)
            mapView.addAnnotation(annotations)
        }
    }

    
    /*
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated);
        manager.desiredAccuracy = kCLLocationAccuracyBest;
        manager.delegate = self;
        manager.requestWhenInUseAuthorization();
        manager.startUpdatingLocation();
        
    }
    
    func locationManager(_ manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
        
        if let location = locations.first{
            manager.stopUpdatingLocation();
            render(location);
        }
    }
    
    
    func render(_ location : CLLocation) {
        
        let coordinate = CLLocationCoordinate2D(latitude: location.coordinate.latitude, longitude: location.coordinate.longitude);
        
        let span = MKCoordinateSpan(latitudeDelta: 0.1, longitudeDelta: 0.1);
        
        let region = MKCoordinateRegion(center: coordinate, span: span);
        
        mapView.setRegion(region, animated: true);
        
        let pin = MKPointAnnotation();
        pin.coordinate = coordinate;
        mapView.addAnnotation(pin);
    }
    */


}
