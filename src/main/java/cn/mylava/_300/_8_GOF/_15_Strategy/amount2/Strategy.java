package cn.mylava._300._8_GOF._15_Strategy.amount2;

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
@AmountRegion(upperBound = 1000)
class Common implements Strategy {
    @Override
    public double getPrice(Double standardPrice) {
        return standardPrice;
    }
}

//银牌会员价格策略
@AmountRegion(lowerBound =1000, upperBound = 3000)
class Silver implements Strategy {
    @Override
    public double getPrice(Double standardPrice) {
        return standardPrice*0.85;
    }
}
//金牌会员价格策略
@AmountRegion(lowerBound =3000)
class Gold implements Strategy {
    @Override
    public double getPrice(Double standardPrice) {
        return standardPrice*0.8;
    }
}