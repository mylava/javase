package cn.mylava._300._8_GOF._15_Strategy.amount3;

/**
 * comment: 计算价格的策略接口
 *
 * @author: lipengfei
 * @date: 22/03/2018
 */
public interface Strategy {
    double getPrice(Double standardPrice);
}

//普通会员价格策略
@AmountRegion(@DetailRegion(upperBound = 1000,order = 99))
class Common implements Strategy {
    @Override
    public double getPrice(Double standardPrice) {
        return standardPrice;
    }
}

//银牌会员价格策略
@AmountRegion(@DetailRegion(lowerBound = 1000,upperBound = 3000,order = 99))
class Silver implements Strategy {
    @Override
    public double getPrice(Double standardPrice) {
        return standardPrice*0.85;
    }
}

//金牌会员价格策略
@AmountRegion(@DetailRegion(lowerBound =3000,order = 99))
class Gold implements Strategy {
    @Override
    public double getPrice(Double standardPrice) {
        return standardPrice*0.8;
    }
}
//满一千减两百
@Once(@DetailRegion(lowerBound = 1000,upperBound = 3000,order = 30))
class Depreciate2Hundred implements Strategy {
    @Override
    public double getPrice(Double standardPrice) {
        return standardPrice-200;
    }
}

//满三千减四百
@Once(@DetailRegion(lowerBound = 3000,order = 30))
class Depreciate4Hundred implements Strategy {
    @Override
    public double getPrice(Double standardPrice) {
        return standardPrice-400;
    }
}