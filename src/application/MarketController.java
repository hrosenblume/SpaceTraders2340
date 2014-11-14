package application;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Manages trading algorithms and control.
 * 
 * @author Stephen
 */
public class MarketController implements Initializable {
    static Planet currentPlanet;

    @FXML
    private Text buyWaterPrice, buyFurPrice, buyFoodPrice, buyOrePrice,
            buyGamesPrice, buyFirearmsPrice, buyMedicinePrice,
            buyMachinesPrice, buyNarcoticsPrice, buyRobotsPrice;
    private int ibuyWaterPrice, ibuyFurPrice, ibuyFoodPrice, ibuyOrePrice,
            ibuyGamesPrice, ibuyFirearmsPrice, ibuyMedicinePrice,
            ibuyMachinesPrice, ibuyNarcoticsPrice, ibuyRobotsPrice;
    @FXML
    private Text[] buyPriceArr;
    private int[] ibuyPriceArr;
    @FXML
    private Text buyWaterAmt, buyFurAmt, buyFoodAmt, buyOreAmt, buyGamesAmt,
            buyFirearmsAmt, buyMedicineAmt, buyMachinesAmt, buyNarcoticsAmt,
            buyRobotsAmt;
    private int ibuyWaterAmt, ibuyFurAmt, ibuyFoodAmt, ibuyOreAmt,
            ibuyGamesAmt, ibuyFirearmsAmt, ibuyMedicineAmt, ibuyMachinesAmt,
            ibuyNarcoticsAmt, ibuyRobotsAmt;
    @FXML
    private Text[] buyAmtArr;
    private int[] ibuyAmtArr;
    @FXML
    private Button plusBuyWater, plusBuyFur, plusBuyFood, plusBuyOre,
            plusBuyGames, plusBuyFirearms, plusBuyMedicine, plusBuyMachines,
            plusBuyNarcotics, plusBuyRobots;
    @FXML
    private Button minusBuyWater, minusBuyFur, minusBuyFood, minusBuyOre,
            minusBuyGames, minusBuyFirearms, minusBuyMedicine,
            minusBuyMachines, minusBuyNarcotics, minusBuyRobots;
    @FXML
    private Text waterLoss, furLoss, foodLoss, oreLoss, gamesLoss,
            firearmsLoss, medicineLoss, machinesLoss, narcoticsLoss,
            robotsLoss;
    private int iwaterLoss, ifurLoss, ifoodLoss, ioreLoss, igamesLoss,
            ifirearmsLoss, imedicineLoss, imachinesLoss, inarcoticsLoss,
            irobotsLoss;
    @FXML
    private Text[] lossArr;
    private int[] ilossArr;
    @FXML
    private Text totalLoss;
    private int itotalLoss;

    @FXML
    private Text sellWaterPrice, sellFurPrice, sellFoodPrice, sellOrePrice,
            sellGamesPrice, sellFirearmsPrice, sellMedicinePrice,
            sellMachinesPrice, sellNarcoticsPrice, sellRobotsPrice;
    private int isellWaterPrice, isellFurPrice, isellFoodPrice, isellOrePrice,
            isellGamesPrice, isellFirearmsPrice, isellMedicinePrice,
            isellMachinesPrice, isellNarcoticsPrice, isellRobotsPrice;
    @FXML
    private Text[] sellPriceArr;
    private int[] isellPriceArr;
    @FXML
    private Text sellWaterAmt, sellFurAmt, sellFoodAmt, sellOreAmt,
            sellGamesAmt, sellFirearmsAmt, sellMedicineAmt, sellMachinesAmt,
            sellNarcoticsAmt, sellRobotsAmt;
    private int isellWaterAmt, isellFurAmt, isellFoodAmt, isellOreAmt,
            isellGamesAmt, isellFirearmsAmt, isellMedicineAmt,
            isellMachinesAmt, isellNarcoticsAmt, isellRobotsAmt;
    @FXML
    private Text[] sellAmtArr;
    private int[] isellAmtArr;
    @FXML
    private Button plusSellWater, plusSellFur, plusSellFood, plusSellOre,
            plusSellGames, plusSellFirearms, plusSellMedicine,
            plusSellMachines, plusSellNarcotics, plusSellRobots;
    @FXML
    private Button minusSellWater, minusSellFur, minusSellFood, minusSellOre,
            minusSellGames, minusSellFirearms, minusSellMedicine,
            minusSellMachines, minusSellNarcotics, minusSellRobots;
    @FXML
    private Text waterGain, furGain, foodGain, oreGain, gamesGain,
            firearmsGain, medicineGain, machinesGain, narcoticsGain,
            robotsGain;
    private int iwaterGain, ifurGain, ifoodGain, ioreGain, igamesGain,
            ifirearmsGain, imedicineGain, imachinesGain, inarcoticsGain,
            irobotsGain;
    @FXML
    private Text[] gainArr;
    private int[] igainArr;
    @FXML
    private Text totalGain;
    private int itotalGain;

    @FXML
    private Text waterCargo, furCargo, foodCargo, oreCargo, gamesCargo,
            firearmsCargo, medicineCargo, machinesCargo, narcoticsCargo,
            robotsCargo;
    private int iwaterCargo, ifurCargo, ifoodCargo, ioreCargo, igamesCargo,
            ifirearmsCargo, imedicineCargo, imachinesCargo, inarcoticsCargo,
            irobotsCargo;
    @FXML
    private Text[] cargoArr;
    private int[] icargoArr;

    @FXML
    private Text totalCargo, maxCargo, netGainLoss, playerMoney;
    private int itotalCargo, imaxCargo, inetGainLoss, iplayerMoney;

    @FXML
    private Text mpTitle;

    @FXML
    private Button cancelButton, checkoutButton;

    /**
     * Sets the current planet to trade on.
     * 
     * @param p
     *            the planet to trade on.
     */
    public static void setPlanet(Planet p) {
        currentPlanet = p;
    }

    /**
     * Displays all of the buyable resources on this planet
     */
    // public void displayBuyPrices() {
    // for (int i = 0; i < Universe.resources.length; i++) {
    // ibuyPriceArr[i] = computeBuyPrice(Universe.resources[i]);
    // buyPriceArr[i].setText(displayBuyPrice(Universe.resources[i]));
    // }
    // }
    //
    // /**
    // * Displays all of the sellable resources on this planet
    // */
    // public void displaySellPrices() {
    // for (int i = 0; i < Universe.resources.length; i++) {
    // isellPriceArr[i] = computeSellPrice(Universe.resources[i]);
    // sellPriceArr[i].setText(displaySellPrice(Universe.resources[i]));
    // }
    // }
    //
    /**
     * Returns the buying price in the form of a String
     * 
     * @param r
     *            the resource to be bought
     * @return the price of the resource, or "Not Buyable" if it cannot be
     *         bought
     */
    private String displayBuyPrice(Resource r) {
        if (!isBuyable(r)) {
            return "Not Buyable";
        }
        return "" + computeBuyPrice(r);
    }

    /**
     * Returns the selling price in the form of a String
     * 
     * @param r
     *            the resource to be sold
     * @return the price of the resource, or "Not Sellable" if it cannot be
     *         bought
     */
    private String displaySellPrice(Resource r) {
        if (!isSellable(r)) {
            return "Not Sellable";
        }
        return "" + computeSellPrice(r);
    }

    /**
     * Calculates the amount of money needed to buy a Resource based on the
     * current planet's tech level and other such conditions
     * 
     * @param r
     *            the resource to be bought
     * @return the price of the resource as an int
     */
    private int computeBuyPrice(Resource r) {
        int price = r.basePrice;
        price +=
                ((currentPlanet.planetTechInteger - r.minTechProduceLevel) * r.techLevelRampUp);
        Random rand = new Random();
        price += rand.nextInt(r.variance);
        // events like war, drought, boredom, lack of workers not implemented
        // yet
        // if (currentPlanet.event.equals(r.highDemandEvent)) price *= 1.5;
        if (currentPlanet.planetResource.equals(r.highProduceResource)) {
            price *= 0.5; // this resource is cheap
        }
        if (currentPlanet.planetResource.equals(r.highDemandResource)) {
            price *= 1.5; // this resource is expensive
        }
        return price;
    }

    /**
     * Calculates the amount of money selling a Resource would produce based on
     * the current planet's tech level and other such conditions
     * 
     * @param r
     *            the resource to be sold
     * @return the price of the resource as an int
     */
    private int computeSellPrice(Resource r) {
        int price = r.basePrice;
        price +=
                ((currentPlanet.planetTechInteger - r.minTechUseLevel) * r.techLevelRampUp);
        Random rand = new Random();
        price += rand.nextInt(r.variance);
        // events like war, drought, boredom, lack of workers not implemented
        // yet
        // if (currentPlanet.event.equals(r.highDemandEvent)) price *= 1.5;
        if (currentPlanet.planetResource.equals(r.highProduceResource)) {
            price *= 0.5; // this resource is cheap
        }
        if (currentPlanet.planetResource.equals(r.highDemandResource)) {
            price *= 1.5; // this resource is expensive
        }
        return price;
    }

    /**
     * Determines whether you can buy a particular resource on a planet.
     * 
     * @param r
     *            the resource to potentially buy.
     * @return true if the resource can be bought, false otherwise.
     */
    public boolean isBuyable(Resource r) {
        return r.minTechProduceLevel <= currentPlanet.planetTechInteger;
    }

    /**
     * Determines whether you can sell a particular resource on a planet.
     * 
     * @param r
     *            the resource to potentially sell.
     * @return true if the resource can be sold, false otherwise.
     */
    public boolean isSellable(Resource r) {
        return r.minTechUseLevel <= currentPlanet.planetTechInteger;
    }

    private void buildArrays() {
        buyPriceArr =
                new Text[] { buyWaterPrice, buyFurPrice, buyFoodPrice,
                        buyOrePrice, buyGamesPrice, buyFirearmsPrice,
                        buyMedicinePrice, buyMachinesPrice, buyNarcoticsPrice,
                        buyRobotsPrice };
        sellPriceArr =
                new Text[] { sellWaterPrice, sellFurPrice, sellFoodPrice,
                        sellOrePrice, sellGamesPrice, sellFirearmsPrice,
                        sellMedicinePrice, sellMachinesPrice,
                        sellNarcoticsPrice, sellRobotsPrice };
        buyAmtArr =
                new Text[] { buyWaterAmt, buyFurAmt, buyFoodAmt, buyOreAmt,
                        buyGamesAmt, buyFirearmsAmt, buyMedicineAmt,
                        buyMachinesAmt, buyNarcoticsAmt, buyRobotsAmt };
        sellAmtArr =
                new Text[] { sellWaterAmt, sellFurAmt, sellFoodAmt, sellOreAmt,
                        sellGamesAmt, sellFirearmsAmt, sellMedicineAmt,
                        sellMachinesAmt, sellNarcoticsAmt, sellRobotsAmt };
        lossArr =
                new Text[] { waterLoss, furLoss, foodLoss, oreLoss, gamesLoss,
                        firearmsLoss, medicineLoss, machinesLoss,
                        narcoticsLoss, robotsLoss };
        gainArr =
                new Text[] { waterGain, furGain, foodGain, oreGain, gamesGain,
                        firearmsGain, medicineGain, machinesGain,
                        narcoticsGain, robotsGain };
        cargoArr =
                new Text[] { waterCargo, furCargo, foodCargo, oreCargo,
                        gamesCargo, firearmsCargo, medicineCargo,
                        machinesCargo, narcoticsCargo, robotsCargo };

        ibuyPriceArr =
                new int[] { ibuyWaterPrice, ibuyFurPrice, ibuyFoodPrice,
                        ibuyOrePrice, ibuyGamesPrice, ibuyFirearmsPrice,
                        ibuyMedicinePrice, ibuyMachinesPrice,
                        ibuyNarcoticsPrice, ibuyRobotsPrice };
        isellPriceArr =
                new int[] { isellWaterPrice, isellFurPrice, isellFoodPrice,
                        isellOrePrice, isellGamesPrice, isellFirearmsPrice,
                        isellMedicinePrice, isellMachinesPrice,
                        isellNarcoticsPrice, isellRobotsPrice };
        ibuyAmtArr =
                new int[] { ibuyWaterAmt, ibuyFurAmt, ibuyFoodAmt, ibuyOreAmt,
                        ibuyGamesAmt, ibuyFirearmsAmt, ibuyMedicineAmt,
                        ibuyMachinesAmt, ibuyNarcoticsAmt, ibuyRobotsAmt };
        isellAmtArr =
                new int[] { isellWaterAmt, isellFurAmt, isellFoodAmt,
                        isellOreAmt, isellGamesAmt, isellFirearmsAmt,
                        isellMedicineAmt, isellMachinesAmt, isellNarcoticsAmt,
                        isellRobotsAmt };
        ilossArr =
                new int[] { iwaterLoss, ifurLoss, ifoodLoss, ioreLoss,
                        igamesLoss, ifirearmsLoss, imedicineLoss,
                        imachinesLoss, inarcoticsLoss, irobotsLoss };
        igainArr =
                new int[] { iwaterGain, ifurGain, ifoodGain, ioreGain,
                        igamesGain, ifirearmsGain, imedicineGain,
                        imachinesGain, inarcoticsGain, irobotsGain };
        icargoArr =
                new int[] { iwaterCargo, ifurCargo, ifoodCargo, ioreCargo,
                        igamesCargo, ifirearmsCargo, imedicineCargo,
                        imachinesCargo, inarcoticsCargo, irobotsCargo };
    }

    private void setScreen() {
        mpTitle.setText(currentPlanet.name + " MarketPlace");
        // displayBuyPrices();
        // displaySellPrices();
        setInitialCargo();
        // initialize imaxCargo from Cargo class
        maxCargo.setText("" + imaxCargo);
        // initialize iplayerMoney from Player class
        playerMoney.setText("" + iplayerMoney);
    }

    private void setInitialCargo() {
        // initialize icargoArr in for-loop from Cargo class
    }

    private void update() {
        buildArrays();
        // for (int i = 0; i < Universe.resources.length; i++) {
        // ilossArr[i] = ibuyPriceArr[i] * ibuyAmtArr[i];
        // igainArr[i] = isellPriceArr[i] * isellAmtArr[i];
        // }
        buildArrays();
        itotalLoss = sum(ilossArr);
        itotalGain = sum(igainArr);
        inetGainLoss = itotalGain - itotalLoss;
        itotalCargo = sum(icargoArr);
        intToDisplay();
    }

    private int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private void intToDisplay() {
        // for (int i = 0; i < Universe.resources.length; i++) {
        // buyAmtArr[i].setText("" + ibuyAmtArr[i]);
        // sellAmtArr[i].setText("" + isellAmtArr[i]);
        // lossArr[i].setText("" + ilossArr[i]);
        // gainArr[i].setText("" + igainArr[i]);
        // cargoArr[i].setText("" + icargoArr[i]);
        // }
        // totalLoss.setText("" + itotalLoss);
        // totalGain.setText("" + itotalGain);
        // netGainLoss.setText("" + inetGainLoss);
        // totalCargo.setText("" + itotalCargo);
    }

    @FXML
    private void onPressCancel(ActionEvent event) throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onPressCheckout(ActionEvent event) throws IOException {
        // add inetGainLoss to Player's money variable
        // set cargoArr to Cargo's individual amt variables with a for-loop
        Stage stage = (Stage) checkoutButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        buildArrays();
        setScreen();
        update();
    }

    @FXML
    private void increaseBuyWater(ActionEvent event) throws IOException {
        incrementBuy("water", 1);
    }

    private void incrementBuy(String item, int val) {
        if (item.equals("water")) {
            ibuyWaterAmt += val;
        }
        update();
    }

    // private void incrementBuy(Text thisLabel) {
    // String currentItem = thisLabel.getText();
    // int currentItemNum = Integer.parseInt(currentItem);
    // int newSkillNum = currentSkillNum + 1;
    // counter--;
    // String newSkill = "" + newSkillNum;
    // thisLabel.setText(newSkill);
    // totalPoints.setText("" + counter);
    // }
    //
    // private void incrementBuy(Text thisLabel) {
    // String currentSkill = thisLabel.getText();
    // int currentSkillNum = Integer.parseInt(currentSkill);
    // int newSkillNum = currentSkillNum + 1;
    // counter--;
    // String newSkill = "" + newSkillNum;
    // thisLabel.setText(newSkill);
    // totalPoints.setText("" + counter);
    // }
    //
    // @FXML
    // private void increasePilot(ActionEvent event) throws IOException {
    // incrementSkill(pilotSkillLabel);
    // }
    // @FXML
    // private void decreasePilot(ActionEvent event) throws IOException {
    // decrementSkill(pilotSkillLabel);
    // }
}
