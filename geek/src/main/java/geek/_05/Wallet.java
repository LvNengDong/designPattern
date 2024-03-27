package geek._05;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * @Author lnd
 * @Description
 * @Date 2024/3/26 12:17
 */

public class Wallet {
    @Getter
    private String id;
    @Getter
    private long createTime;
    @Getter
    private BigDecimal balance;
    @Getter
    private long balanceLastModifiedTime;

    public Wallet(){
        this.id = IdGenerator.getInstance().generate();
        this.createTime = System.currentTimeMillis();
        this.balance = BigDecimal.ZERO;
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }

    /**
     * 充值
     * @param increaseAmount 充值金额
     */
    public void increaseBalance(BigDecimal increaseAmount){
        if (increaseAmount.compareTo(BigDecimal.ZERO) < 0){
            throw new InvalidAmountException("充值金额不能小于0");
        }
        this.balance.add(increaseAmount);
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }

    /**
     * 消费
     * @param decreaseAmount 消费金额
     */
    public void decreaseBalance(BigDecimal decreaseAmount){
        if (decreaseAmount.compareTo(BigDecimal.ZERO) < 0){
            throw new InvalidAmountException("消费金额不能小于0");
        }
        if (decreaseAmount.compareTo(this.balance) > 0){
            throw new InsufficientAmountException("当前账户余额不足，请充值");
        }
        this.balance.subtract(decreaseAmount);
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }
}
