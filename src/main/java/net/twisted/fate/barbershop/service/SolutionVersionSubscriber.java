package net.twisted.fate.barbershop.service;

import net.twisted.fate.barbershop.entity.SolutionVersion;

/**
 * TODO
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/10
 */
public interface SolutionVersionSubscriber {

    void onCreate(SolutionVersion solutionVersion);

    void onRollback(SolutionVersion solutionVersion);

}
